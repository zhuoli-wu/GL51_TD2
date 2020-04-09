package gl51

import groovy.transform.PackageScope
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import gl51.movie.data.MovieRequest
import gl51.movie.data.Movie
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Post
import gl51.movie.service.impl.MovieRegistryImpl

import javax.inject.Inject

@Controller("/movie")
class MovieController {
    @Inject MovieRegistryImpl registry

    @Get("/")
    List<Movie> index() {
        registry.listFavorites()
    }

    @Post('/')
    HttpStatus addMovie(MovieRequest movieRequest){
        registry.addMovieToFavorites(movieRequest.imdbId)
        HttpStatus.CREATED
    }


}