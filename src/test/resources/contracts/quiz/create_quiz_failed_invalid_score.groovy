package quiz

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description '''
Represents creating a new quiz

given:
    an invalid score
when:
    a teacher create a new paper
then:
    this teacher should get bad request
'''

    request {
        url "/quizzes"
        method POST()
        headers {
            contentType applicationJson()
        }
        body(
                teacherId: $(consumer(regex('[a-zA-Z0-9]{36}'))),
                question: $(consumer(regex('.{1,255}'))),
                score: 110,
                referenceAnswer: $(consumer(regex('.{1,4000}')))
        )
    }

    response {
        status BAD_REQUEST()
        headers {
            contentType applicationJson()
        }
        body(
                errorMsg: 'Invalid Score',
        )
    }
}