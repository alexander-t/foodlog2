package se.tarlinder.foodlog.interceptor


class AuthInterceptor {

    AuthInterceptor() {
        match(controller: 'calendar')
    }

    boolean before() {
        if (!session.user) {
            redirect(controller: 'login')
            return false
        }
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
