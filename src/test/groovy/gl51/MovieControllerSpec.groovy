package gl51

import gl51.movie.service.MovieClient
import gl51.movie.service.impl.MovieClientImpl
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Shared
import gl51.movie.data.MovieRequest
import gl51.movie.data.Movie
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.micronaut.test.annotation.MockBean
import javax.inject.Inject

@MicronautTest
class MovieControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    RxHttpClient client

    void "test addfilm par post"() {
        given:
        HttpResponse response = client.toBlocking().exchange(HttpRequest.POST("/movie",new MovieRequest(imdbID:  "aaa")))

        expect:
        response.status == HttpStatus.CREATED
    }

    @MockBean(MovieClientImpl)
    MovieClient client(){
        def mock = Mock(MovieClient)
        mock.getMovieDetail("aaa")>>new Movie(imdbID: "aaa",title: "my movie")
        mock
    }
}
