package app.admin.jobsboard

class Type {
    String name
    String description

    Date dateCreated
    Date lastUpdated

    static constraints = {
        name blank: false
        description nullable: true, blank: true
    }
}
