package se.tarlinder.foodlog.trait

trait IsLoggedIn {
    def isLoggedIn() {
        if (!session.user) {
            redirect(controller: 'login')
            return false
        }
    }
}
