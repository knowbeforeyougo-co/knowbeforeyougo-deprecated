const express = require('express');
const router = express.Router();
const Organization = require('../../model/Organization');

/* POST startup */
router.post('/startup', async function (req, res, next) {
    const organizationId = req.body.organizationId;
    const id = req.body.id;
    const token = req.body.token;

    if (!organizationId || !id || !token) {
        // notify me via phone #

        // deny
        return deny(res, "Invalid organization, id, or token.");
    }

    const organization = await Organization.find({
        _id: organizationId,
        clients: {
            $elemMatch: {
                _id: id,
                token: token
            }
        }
    });

    if (!organization) {
        // deny
        return deny(res, "Invalid organization, id, or token.");
    }

    // update last startup time for client
    const query = {_id: organizationId};
    const updateDocument = {
        $push: {"clients.$[_id].lastStartupTime": Date.now()}
    };

    await Organization.updateOne(query, updateDocument);

    res.send("Startup");
});

/* POST startup */
router.post('/startup', function (req, res, next) {
    const organization = req.body.organization;
    const uuid = req.body.uuid;
    const token = req.body.token;

    if (!organization || !uuid || !token) {
        // notify me via phone #

        // deny
        return deny(res, "Invalid organization, id, or token.");
    }

    res.send("Startup");
});

const deny = (res, message) => {
    res.status(403).send({success: false, message: message});
}

module.exports = router;
