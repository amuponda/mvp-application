package app.admin.jobsboard

class Job {

    String title
    String description
    Date expirationDate

    String jobUrl
    String contactEmail
    String applyInstructions

    String salaryEstimate
    Boolean remote
    Boolean active

    Type type
    Publisher publisher

    static hasMany = [tags: Tag]

    static constraints = {
        title nullable: false, blank: false
        description nullable: false, blank: false, type: 'text'
        jobUrl blank: false
        contactEmail nullable: false, blank: false, email: true
        applyInstructions nullable: false, blank: false
        salaryEstimate nullable: true, blank: true, size: 10..100 * 1024
        active defaultValue: false
        expirationDate nullable: true
        remote nullable: true
        type nullable: true
        publisher nullable: true
    }
}
