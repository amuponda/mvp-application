package app.admin.jobsboard

class Publisher {
    String name
    byte [] logo
    String logoBase64
    String logoUrl
    String url
    String twitterId
    String contactEmail

    String location

    Date dateCreated
    Date lastUpdated

    static constraints = {
        name blank: false
        url blank: false, url: true
        twitterId nullable: true, blank: true
        contactEmail blank: false, email: true
        location blank: false
        logo size: 0..1024 * 1024 * 1, maxSize: 1024 * 1024 * 1, nullable: true // 1MB
        logoBase64 nullable: true, blank: true
        logoUrl nullable: true, blank: true
    }

    static transients = ['logoBase64']
}
