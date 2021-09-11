$("#start").click( () => {
    $("#start").hide()
    $("main").show()
})

let vidas = 3
let puntos = 0


let pregunta = traerPreguntaRandom()
chequearRespuesta(pregunta)



function traerPreguntaRandom() {

    $.get("/questionados/next", (resp, status) => {

        $("main").prepend(`
        <section id="question" class="question container-fluid">
            <h2 class="row justify-content-center">- ${resp.enunciado} -</h2>
            <h5 class="row justify-content-center">${resp.categoria.nombre}</h5>
        </section>

        <section id="options" class="options d-grid gap-3 col-5 mx-auto">
            <button id="op1" class="btn op">${resp.opciones[0].texto}</button>
            <button id="op2" class="btn op">${resp.opciones[1].texto}</button>
            <button id="op3" class="btn op">${resp.opciones[2].texto}</button>
        </section>

        <section id="score" class="score">
            <h1 id="points" class="points">${puntos}</h1>
            <h1 id="lifes" class="lifes">${vidas}</h1>
        </section>
        `)

        return resp
    })
}

function chequearRespuesta(resp) {

    const URL = "/questionados/verificaciones"
    
    $("#op1").click( () => {

        const infoResp = {
            preguntaId : resp.preguntaId,
            respuestaId : resp.opciones[0].respuestaId
        }

        $.post(URL, infoResp, (respuesta, estado) => {

            if (respuesta.esCorrecta == "true") {
                puntos++
            } else {
                vidas = vidas - 1
            }
        })
    })

    $("#op2").click( () => {

        const infoResp = {
            preguntaId : resp.preguntaId,
            respuestaId : resp.opciones[0].respuestaId
        }

        $.post(URL, infoResp, (respuesta, estado) => {

            if (respuesta.esCorrecta == "true") {
                puntos++
            } else {
                vidas = vidas - 1
            }
        })
    })

    $("#op3").click( () => {

        const infoResp = {
            preguntaId : resp.preguntaId,
            respuestaId : resp.opciones[0].respuestaId
        }

        $.post(URL, infoResp, (respuesta, estado) => {

            if (respuesta.esCorrecta == "true") {
                puntos++
            } else {
                vidas = vidas - 1
            }
        })
    })
}
