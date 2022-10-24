import {useState} from "react";
import {Button, Col, Form, Row} from "react-bootstrap";


const Addition = () => {
    const [addOne, setAddOne] = useState("0");
    const [addTwo, setAddTwo] = useState("0");
    const [addAnswer, setAddAnswer] = useState(0);

    const onSubmit = async (event: React.SyntheticEvent) => {
        event.preventDefault();

        const result = await fetch(`http://localhost:8080/additionCalcul`,
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    "number1": addOne,
                    "number2": addTwo
                })
            }).then(res => res.json())
            .then(res => {
                setAddAnswer(res.answer);
            });
    }

    return(
        <Form onSubmit={onSubmit}>
            <Col className="bg-light px-4 pb-2 pt-1">
                <Row>
                    <Col>
                        <Form.Group>
                            <Form.Label className="fw-bold h5">One</Form.Label>
                            <Form.Control type="text" minLength={1} required value={addOne}
                                          onChange={field => setAddOne(field.target.value)}></Form.Control>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group>
                            <Form.Label className="fw-bold h5">Two</Form.Label>
                            <Form.Control minLength={1} type="text" required value={addTwo}
                                          onChange={field => setAddTwo(field.target.value)}></Form.Control>
                        </Form.Group>
                    </Col>
                </Row>
                <Row className="mt-3">
                    <Button type="submit" className="btn btn-success mx-auto">Addition</Button>
                </Row>
                <Row className="mt-3">
                    <h3>
                        {addAnswer}
                    </h3>
                </Row>
            </Col>
        </Form>
    );
}

export default Addition;