package gl51.movie.service.impl

import gl51.movie.service.MovieClient
import gl51.movie.service.MovieRegistry
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import javax.inject.Inject



@MicronautTest
class MovieClientImplTest extends Specification{
    @Inject MovieClientImpl client
    @Inject MovieRegistry registry
    void "injectionShouldWork"() {
        expect:
        registry != null
        client != null
    }
    void "getMovieDetailShouldWork"(){
        when:
        registry.addMovieToFavorites("aaa")
        then:
        registry.listFavorites().size() == 1
        client.getMovieDetail("aaa") != null
    }

    @MockBean(MovieClientImpl)
    MovieClient mClient() {
        Mock(MovieClient)
    }
}
