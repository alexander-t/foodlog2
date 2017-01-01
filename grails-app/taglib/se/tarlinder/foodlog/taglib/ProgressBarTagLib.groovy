package se.tarlinder.foodlog.taglib

class ProgressBarTagLib {
    static namespace = 'fl'
    static defaultEncodeAs = [taglib: 'raw']
    static returnObjectForTags = ['progressBar']

    /**
     * Renders a Bootstrap progress bar.
     *
     * @attr progress progress in the bar. Defaults to 0 if not provided.
     * @attr max bar maximum value. Defaults to 100.0 if not provided.
     */
    def progressBar = { attrs, body ->
        BigDecimal progress = 0g
        if (attrs?.progress instanceof Number || attrs?.progress instanceof String) {
            progress = new BigDecimal(attrs.progress).max(0g)
        }

        BigDecimal max = 100g
        if (attrs?.max instanceof Number || attrs?.max instanceof String) {
            max = new BigDecimal(attrs.max)
        }

        int percentage
        if (progress <= max) {
            percentage = (int) (100 * progress / max)
        } else {
            percentage = 100
        }
        render(template: "/templates/progressBarTemplate", model: [percentage: percentage])
    }
}
