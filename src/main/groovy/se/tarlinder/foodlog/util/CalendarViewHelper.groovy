package se.tarlinder.foodlog.util

class CalendarViewHelper {
    static intelligentProgressBar(double progress, double max) {
        final float warningThreshold = 1.1
        def percentage = 0;
        def styleClass = "progress progress-striped "
        if (progress <= max) {
            percentage = (int) (100 * progress / max)
            styleClass += "progress-success"
        } else {
            percentage = 100
            styleClass += (progress > max * warningThreshold) ? "progress-danger" : "progress-warning"
        }
        "<div style=\"margin-bottom:5px;\" class=\"${styleClass}\"><div class=\"bar\" style=\"width: ${percentage}%\"></div></div>"
    }

    static simpleProgressBar(double progress, double max) {
        def percentage = 0;
        if (progress <= max) {
            percentage = (int) (100 * progress / max)
        } else {
            percentage = 100
        }
        "<div style=\"margin-bottom:5px;\" class=\"progress progress-striped progress-info\"><div class=\"bar\" style=\"width: ${percentage}%\"></div></div>"
    }
}
