package se.tarlinder.foodlog.taglib

class ProgressBarTagLib {
    static defaultEncodeAs = [taglib: 'raw']
    static returnObjectForTags = ['progressBar']

    /**
     * Renders a Bootstrap progress bar.
     *
     * @attr progress progress in the bar. Defaults to 0 if not provided.
     * @attr max bar maximum value. Defaults to 100.0 if not provided.
     */
    def progressBar = { attrs, body ->
        double progress = 0
        if (attrs.progress != null) {
            if (attrs.progress instanceof Double || attrs.progress instanceof Float) {
                progress = new Double(attrs.progress).doubleValue()
            } else if (attrs.progress instanceof String) {
                progress = Double.parseDouble(attrs.progress)
            }
        }

        double max = 100d
        if (attrs.max != null) {
            if (attrs.max instanceof Double || attrs.max instanceof Float) {
                max = new Double(attrs.max).doubleValue()
            } else if (attrs.max instanceof String) {
                max = Double.parseDouble(attrs.max)
            }
        }

        int percentage = 0
        if (progress <= max) {
            percentage = (int) (100 * progress / max)
        } else {
            percentage = 100
        }
        render(template: "progressBarTemplate", model: [percentage: percentage])
        //out << "<div style=\"margin-bottom:5px;\" class=\"progress progress-striped progress-info\">"
        //out << "<div class=\"bar\" style=\"width: ${percentage}%\"></div></div>"
    }
}
