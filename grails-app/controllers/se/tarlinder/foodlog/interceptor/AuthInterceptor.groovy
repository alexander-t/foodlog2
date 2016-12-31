package se.tarlinder.foodlog.interceptor


class AuthInterceptor {

    AuthInterceptor() {
        match(controller: 'calendar')
        match(controller: 'day')
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
