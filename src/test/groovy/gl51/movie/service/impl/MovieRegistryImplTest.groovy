package gl51.movie.service.impl
import gl51.movie.data.Movie
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import io.micronaut.test.annotation.MockBean
import gl51.movie.service.MovieClient

import javax.inject.Inject

@MicronautTest
class MovieRegistryImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry

    void "injectionShouldWork"() {
        expect:
            registry != null
    }

    void "favoritesShouldBeEmpty"() {
        expect:
            registry.listFavorites() == []
    }

    void "addingAFacoviteShouldFillInTheDatabase"() {
        when:
            registry.addMovieToFavorites("aaaaa")
        then:
            registry.listFavorites().size() == 1
    }
    @MockBean(MovieClientImpl)
    MovieClient movieClient() {
        def mock = Mock(MovieClient)
        mock.getMovieDetail("aaaaa") >> new Movie(imdbID: "aaaaa", title: 'my movie')
        mock
    }
}
