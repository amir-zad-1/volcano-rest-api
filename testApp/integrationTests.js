const chai = require("chai");
const assert = chai.assert;
const chaiHttp = require("chai-http");

chai.use(chaiHttp);


const API_BASE_URL = "http://localhost:8080/";
const API_RESERVATION_ENDPOINT = API_BASE_URL + "reservations";

const resetAPI = () => {
    return new Promise((resolve, reject) => {
        chai.request(API_BASE_URL).post("/reset").end((error, response) => {
            if (error) return reject(error);
            return resolve(response.body);
        });
    });
};

const makeReservation = (data) => {
    return new Promise((resolve, reject) => {
        chai.request(API_RESERVATION_ENDPOINT).post("/").send(data).end((error, postResponse) => {
            if (error) return reject(error);
            return resolve(postResponse.body);
        });
    });

};

describe("before any reservation", () => {

    before(done => {
        resetAPI().then(resetResponse => {
            assert.equal(resetResponse.ok, true);
            done();
        }).catch(error => done(error));
    });


    describe("/reservation endpoint", () => {

        it("returns empty list", done => {
            chai.request(API_RESERVATION_ENDPOINT).get("/").end((error, response) => {
                if (error) done(error);
                assert.equal(response.body.length, 0);
                done();
            });
        });

        it("returns 404 error when non-existed reservation id is received", done => {
            const nonExistedId = 10;
            chai.request(API_RESERVATION_ENDPOINT).get("/" + nonExistedId).end((error, response) => {
                assert.equal(response.statusCode, 404);
                done();
            });
        });

    });

    it("/reservations/getavailabledates returns array of 30 available dates  when no reservation is made", done => {
        chai.request(API_RESERVATION_ENDPOINT).get("/availabledates").end((error, response) => {
            if (error) done(error);
            assert.equal(response.body.length, 30);
            done();
        });
    });

});


describe("/reservations endpoint", () => {

    const reservationData = {
        customerEmail: "am1hosseinzadeh@gmail.com",
        arrivalDate: "2018-11-10",
        duration: 3
    };
    let newReservation;

    beforeEach(done => {
        makeReservation(reservationData).then(resevation => {
            newReservation = resevation;
            done();
        }).catch(error => done(error));
    });

    afterEach(done => {
        resetAPI().then(resetResponse => {
            assert.equal(resetResponse.ok, true);
            done();
        }).catch(error => done(error));
    });

    it("new reservation duration should be 3", done => {
        assert.equal(newReservation.duration, 3);
        done();
    });

    it("/reservations/getavailabledates returns array of less than 30 available dates", done => {
        chai.request(API_RESERVATION_ENDPOINT).get("/availabledates").end((error, response) => {
            if (error) done(error);
            assert.isBelow(response.body.length, 30);
            done();
        });
    });

    it("creating the second reservation with the same arrival date should return HTTP BAD REQUEST 400 Error", done => {
        makeReservation(reservationData).then((response) => {
            assert.equal(response.status, 400);
            done();
        }).catch(error => done(error));
    });

    it("update reservation duration to 5 days should return HTTP BAD REQUEST 400 Error", done => {
        const updateData = {
            id: newReservation.id,
            customerEmail: newReservation.customerEmail,
            arrivalDate: newReservation.arrivalDate,
            duration: 5
        };
        chai.request(API_RESERVATION_ENDPOINT).put("/").send(updateData).end((error, putResponse) => {
            if (error) return done(error);
            assert.equal(putResponse.status, 400);
            done();
        });
    });

    it("update reservation duration to 1 days should return HTTP BAD REQUEST 400 Error", done => {
        const updateData = {
            id: newReservation.id,
            customerEmail: newReservation.customerEmail,
            arrivalDate: newReservation.arrivalDate,
            duration: 1
        };
        chai.request(API_RESERVATION_ENDPOINT).put("/").send(updateData).end((error, putResponse) => {
            if (error) return done(error);
            assert.equal(putResponse.body.duration, updateData.duration);
            done();
        });
    });


    it("cancel reservation should return success with value of true", done => {
        chai.request(API_RESERVATION_ENDPOINT).delete("/" + newReservation.id).end((error, deleteResponse) => {
            if (error) return done(error);
            assert.isOk(deleteResponse.body.success);
            done();
        });
    });

    it("cancel reservation should return array of 30 available dates", done => {
        chai.request(API_RESERVATION_ENDPOINT).delete("/" + newReservation.id).end((error, deleteResponse) => {
            if (error) return done(error);
            chai.request(API_RESERVATION_ENDPOINT).get("/availabledates").end((error, response) => {
                if (error) done(error);
                assert.equal(response.body.length, 30);
                done();
            });
        });
    });

});

