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
        title blank: false
        description blank: false, type: 'text'
        jobUrl blank: false
        contactEmail blank: false, email: true
        applyInstructions blank: false
        salaryEstimate blank: true, size: 10..100 * 1024
        active defaultValue: false
        expirationDate nullable: true
        remote nullable: true
        type nullable: true
        publisher nullable: true
    }
}
