package de.triplet.gradle.play

class PlayPublisherPluginExtension {

    String serviceAccountEmail

    File pk12File

    boolean uploadImages = false

    private String track = 'alpha'

    private Double userFraction

    void setTrack(String track) {
        if (!(track in ['alpha', 'beta', 'production', 'rollout'])) {
            throw new IllegalArgumentException("Track has to be one of 'alpha', 'beta', 'production' or 'rollout'.")
        }

        this.track = track
    }

    void setUserFraction(Double fraction) {
        if (!(fraction in [0.005D, 0.01D, 0.05D, 0.1D, 0.2D, 0.5D, 1.0D])) {
            throw new IllegalArgumentException("userFraction has to be one of 0.005, 0.01, 0.05, 0.1, 0.2, 0.5 or 1.0")
        }

        this.userFraction = fraction
    }

    def getTrack() {
        return track
    }

    def getUserFraction() {
        return userFraction
    }

}
