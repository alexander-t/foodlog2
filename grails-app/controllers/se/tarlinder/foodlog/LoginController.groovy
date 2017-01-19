package se.tarlinder.foodlog

import se.tarlinder.foodlog.domain.User

class LoginController {

    def index() {

    }

    def login() {
        def user = User.findWhere(name: params.u, password: params.p)
        if (user) {
            session.user = user
            if (params.dest) {
                redirect(uri: params.dest)
            } else {
                redirect(controller: 'calendar')
            }
        } else {
            redirect(controller: 'login')
        }
    }

    def logout() {
        session.user = null
        redirect(url: '/')
    }
}
