external fun require(module: String): dynamic

fun main(args: Array<String>) {

    val express = require("express")
    val app = express()

    app.get("/", { _, res ->
        res.type("text/plain")
        res.send("Hi 20Scoops CNX")
    })

    app.get("/:name", { req, res ->
        val user = User()
        user.name = req.params.name.toString()
        res.setHeader("Content-Type", "application/json")
        res.send(JSON.stringify(user))
    })

    app.listen(3000, {
        println("Listening on port 3000")
    })
}