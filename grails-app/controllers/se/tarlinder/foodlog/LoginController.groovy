package se.tarlinder.foodlog

import se.tarlinder.foodlog.domain.User

class LoginController {

    def index() {

    }

    def login() {
        def user = User.findWhere(name: params.u, password: params.p)
        if (user) {
            session.user = user
            redirect(controller: 'calendar', action: 'index')
        } else {
            redirect(controller: 'login', action: 'index')
        }
    }

    def logout() {
        session.user = null
        redirect(url: '/')
    }
}
