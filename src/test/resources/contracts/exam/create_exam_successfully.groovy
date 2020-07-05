package exam

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description '''
Represents creating a new paper

given:
    Some valid blank quizzes
when:
    a teacher assemble a new paper
then:
    thi teacher should get a valid paperId
'''

    request {
        url "/examinations"
        method POST()
        headers {
            contentType applicationJson()
        }
        body(
                time: 60
        )
    }

    response {
        status CREATED()
        headers {
            contentType applicationJson()
        }
    }
}
