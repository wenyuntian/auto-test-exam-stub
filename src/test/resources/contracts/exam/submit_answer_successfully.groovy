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
        url $(consumer("/examinations/${regex('[a-zA-Z-0-9]{36}')}/answer-sheet/${regex('[a-zA-Z-0-9]{36}')}"),
        producer("/examinations/9idk4-lokfu-jr874j3-h8d9j4-hor82kd71/answer-sheet/9idk4-lokfu-jr874j3-h8d9j4-ho7kdl0"))
        method PUT()
        body(
                studentId: regex('[a-zA-Z-0-9]{36}'),
                answer: anyNonBlankString(),
                startTime: '2020-07-04T00:00:00',
                submitTime: '2020-07-04T01:00:00',
        )
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                answerSheetId: regex('[a-zA-Z-0-9]{36}'),
                examinationId: regex('[a-zA-Z-0-9]{36}'),
                studentId: fromRequest().body('$.studentId'),
                answer: fromRequest().body('$.answer'),
                startTime: fromRequest().body('$.startTime'),
                submitTime: fromRequest().body('$.submitTime')
        )
    }
}
