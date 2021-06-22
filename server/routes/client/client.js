const express = require('express');
const router = express.Router();

/* POST startup */
router.post('/startup', function (req, res, next) {
    const organization = req.body.organization;
    const uuid = req.body.uuid;
    const token = req.body.token;

    if (!organization || !uuid || !token) {
        // notify me via phone #

        // deny
        return deny(res, "Invalid organization, uuid, or token.");
    }

    res.send("Startup");
});

const deny = (res, message) => {
    res.status(403).send({success: false, message: message});
}

module.exports = router;
