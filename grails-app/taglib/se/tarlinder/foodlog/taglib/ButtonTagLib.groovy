package se.tarlinder.foodlog.taglib;

class ButtonTagLib {
    static namespace = 'fl'
    static defaultEncodeAs = [taglib: 'raw']
    static returnObjectForTags = ['addButton']

    /**
     * Renders a simple "Add" addButton with an icon
     */
    def addButton = { attrs, body ->
        render(template: "/templates/addButtonTemplate")
    }
}
