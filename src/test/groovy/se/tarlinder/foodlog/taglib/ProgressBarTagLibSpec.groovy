package se.tarlinder.foodlog.taglib

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(ProgressBarTagLib)
class ProgressBarTagLibSpec extends Specification {

    void "A progress bar with no attributes defaults to 0/100"() {
        given:
        def html = applyTemplate('<fl:progressBar/>')

        expect:
        html =~ /aria-valuemin="0"/
        html =~ /aria-valuenow="0"/
        html =~ /aria-valuemax="100"/
        html =~ /style="width:\s?0%/
    }

    void "A progress bar with only the progress attribute defaults to progress/100"() {
        given:
        def html = applyTemplate('<fl:progressBar progress="33"/>')

        expect:
        html =~ /aria-valuemin="0"/
        html =~ /aria-valuenow="33"/
        html =~ /aria-valuemax="100"/
        html =~ /style="width:\s?33%/
    }

    void "A progress bar with progress < 100 is green"() {
        given:
        def html = applyTemplate('<fl:progressBar progress="99"/>')

        expect:
        html =~ /aria-valuemin="0"/
        html =~ /class=".*progress-bar-success.*?"/
    }

    void "A progress bar with progress = 100 is red"() {
        given:
        def html = applyTemplate('<fl:progressBar progress="100"/>')

        expect:
        html =~ /aria-valuemin="0"/
        html =~ /class=".*progress-bar-danger.*?"/
    }

    void 'Taglib string arguments are supported'() {
        expect: "Progress to be 10/50 = 20"
        tagLib.progressBar([progress: "10", max: "50"]) =~ /aria-valuenow="20"/
    }

    void 'Taglib floating point arguments are supported'() {
        expect: "Progress to be 10/50 = 20"
        tagLib.progressBar([progress: 10d, max: 50d]) =~ /aria-valuenow="20"/
        tagLib.progressBar([progress: 25f, max: 50f]) =~ /aria-valuenow="50"/
    }

    void 'Taglib integer arguments are supported'() {
        expect: "Progress to be 10/50 = 20"
        tagLib.progressBar([progress: 10, max: 50]) =~ /aria-valuenow="20"/
        tagLib.progressBar([progress: 25l, max: 50l]) =~ /aria-valuenow="50"/
    }

    void 'Negative progress is treated as zero'() {
        expect:
        tagLib.progressBar([progress: -999]) =~ /aria-valuenow="0"/
    }
}
