package quiz

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description '''
Represents creating a new quiz

given:
    a valid blank quiz info
when:
    a teacher create a new paper
then:
    this teacher should get a valid blankQuizId
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
                score: $(consumer(regex('100|[1-9][0-9]|[1-9]'))),
                referenceAnswer: $(consumer(regex('.{1,4000}')))
        )
    }

    response {
        status CREATED()
        headers {
            contentType applicationJson()
        }
        body(
                quizId: $(producer(regex('[a-zA-Z-0-9]{36}')), consumer('8jk4l-k0d9ie7-4jk89l-t8ikdj6-h50o8ij'))
        )
    }
}