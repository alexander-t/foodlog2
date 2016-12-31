dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    dialect = org.hibernate.dialect.PostgreSQL9Dialect

    uri = new URI(System.env.DATABASE_URL ?: "postgres://foodlog:logfood@cluster3/foodlog")
    url = "jdbc:postgresql://" + uri.host + uri.path
    username = uri.userInfo.split(":")[0]
    password = uri.userInfo.split(":")[1]

    validationQuery = "select 1"
    testOnBorrow = true
    testWhileIdle = true
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop"
        }
        hibernate {
            show_sql = true
        }
    }
    test {
        dataSource {
            dbCreate = "validate"
        }
        hibernate {
            show_sql = true
        }
    }
    production {
        dataSource {
            dbCreate = "update"
        }
    }
}
