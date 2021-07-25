const express = require('express');
const router = express.Router();
const Organization = require('../../model/Organization');
const Snapshot = require('../../model/Snapshot');

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

    const organization = await Organization.findOne({
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
        $push: {"clients.$[client].lastStartupTime": Date.now()}
    };
    const options = {
        arrayFilters: [{
            "client._id": id
        }]
    };

    await Organization.updateOne(query, updateDocument, options);

    return allow(res);
});

/* POST snapshot */
router.post('/snapshot', async function (req, res, next) {
    const organizationId = req.body.organizationId;
    const id = req.body.id;
    const token = req.body.token;
    const macAddresses = req.body.macAddresses;

    if (!organizationId || !id || !token || !macAddresses) {
        return deny(res, "Invalid organization, id, token, or mac address array.");
    }

    const organization = await Organization.findOne({
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

    // create new snapshot
    const snapshot = new Snapshot({
        clientId: id,
        macAddresses: macAddresses
    });
    await snapshot.save();

    return allow(res);
});

const deny = (res, message) => {
    res.status(403).send({success: false, message: message === undefined ? "None" : message});
}

const allow = (res, message) => {
    res.status(200).send({success: true, message: message === undefined ? "None" : message});
}

module.exports = router;
