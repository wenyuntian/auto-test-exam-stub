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
        url $(consumer("/examinations/${regex('[a-zA-Z-0-9]{36}')}/answer-sheets"),
        producer("/examinations/9idk4-lokfu-jr874j3-h8d9j4-hor82kd71/answer-sheets"))
        method POST()
    }

    response {
        status CREATED()
        headers {
            contentType applicationJson()
        }
        body(
                answerSheetId: '8jk4l-k0d9ie7-4jk89l-t99ijj6-h8i9040',
                studentId: '8jk4l-k0d9ie7-4jk89l-t99ijj6-h8i9040',
                examId: '8jk4l-k0d9ie7-4jk89k-t99ijj6-h8i9040',
                teacherId: '8jk4l-k0d9ie7-4jk89l-t88ijj6-h8i9040',
                paperId: '8jk4l-k0d9ie7-4jk89l-t88irr7-h8i9040',
                time: 60,
        )
    }
}
