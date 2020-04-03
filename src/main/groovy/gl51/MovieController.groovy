package gl51

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus


@Controller("/movie")
class MovieController {

    @Get("/")
    HttpStatus index() {
        return HttpStatus.OK
    }
}