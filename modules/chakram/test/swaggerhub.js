var chakram = require('chakram');
var expect = chakram.expect;

describe("SwaggerHub", function () {
    it("should get number of TestServer APIs", function () {
        var response = chakram.get("https://api.swaggerhub.com/apis?query=testserver");
        return expect(response).to.comprise.of.json({
            totalCount: 4
        });
    });
});