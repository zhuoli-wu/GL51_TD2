package gl51.movie.service

import gl51.movie.data.Movie

interface MovieClient {
    Movie getMovieDetail(String imdbID)
}