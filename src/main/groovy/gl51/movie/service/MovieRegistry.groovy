package gl51.movie.service

import gl51.movie.data.Movie

interface MovieRegistry {
    void addMovieToFavorites(String imdbID)
    List<Movie> listFavorites()
}