package app.admin.jobsboard

class Publisher {
    String name
    byte [] logo
    String url
    String twitterId
    String contactEmail

    String location

    Date dateCreated
    Date lastUpdated

    static constraints = {
        name blank: false
        url blank: false
        contactEmail blank: false, email: true
        location blank: false
        logo size: 0..1024 * 1024 * 5, maxSize: 1024 * 1024 * 5 //5MB
    }
}
