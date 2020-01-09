package com.example.moviemvvmrxjavaretrofit.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MoviePopular {
    @SerializedName("page")
    private final int page;

    @SerializedName("total_results")
    private final int totalResults;

    @SerializedName("total_pages")
    private final int totalPages;

    @SerializedName("results")
    private final List<Results> results;

    public MoviePopular(int page, int totalResults, int totalPages, List<Results> results) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Results> getResults() {
        return results;
    }

    public static class Results {
        @SerializedName("popularity")
        private final double popularity;

        @SerializedName("vote_count")
        private final int voteCount;

        @SerializedName("video")
        private final boolean video;

        @SerializedName("poster_path")
        private final String posterPath;

        @SerializedName("id")
        private final int id;

        @SerializedName("adult")
        private final boolean adult;

        @SerializedName("backdrop_path")
        private final String backdropPath;

        @SerializedName("original_language")
        private final String originalLanguage;

        @SerializedName("original_title")
        private final String originalTitle;

        @SerializedName("genre_ids")
        private final List<Integer> genreIds;

        @SerializedName("title")
        private final String title;

        @SerializedName("vote_average")
        private final double voteAverage;

        @SerializedName("overview")
        private final String overview;

        @SerializedName("release_date")
        private final String releaseDate;

        public Results(double popularity, int voteCount, boolean video, String posterPath, int id,
                       boolean adult, String backdropPath, String originalLanguage, String originalTitle,
                       List<Integer> genreIds, String title, double voteAverage, String overview,
                       String releaseDate) {
            this.popularity = popularity;
            this.voteCount = voteCount;
            this.video = video;
            this.posterPath = posterPath;
            this.id = id;
            this.adult = adult;
            this.backdropPath = backdropPath;
            this.originalLanguage = originalLanguage;
            this.originalTitle = originalTitle;
            this.genreIds = genreIds;
            this.title = title;
            this.voteAverage = voteAverage;
            this.overview = overview;
            this.releaseDate = releaseDate;
        }

        public double getPopularity() {
            return popularity;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public boolean isVideo() {
            return video;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public int getId() {
            return id;
        }

        public boolean isAdult() {
            return adult;
        }

        public String getBackdropPath() {
            return "https://image.tmdb.org/t/p/w500/"+backdropPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public String getTitle() {
            return title;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        public String getOverview() {
            return overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }
    }
}
