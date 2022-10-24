import {useState} from "react";
import {Button, Col, Form, Row} from "react-bootstrap";

const Soustraction = () => {
    const [sousOne, setSousOne] = useState("0");
    const [sousTwo, setSousTwo] = useState("0");
    const [SousAnswer, setSousAnswer] = useState(0);

    const onSubmit = async (event: React.SyntheticEvent) => {
        event.preventDefault();

        const result = await fetch(`http://localhost:8080/soustractionCalcul`,
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    "number1": sousOne,
                    "number2": sousTwo
                })
            }).then(res => res.json())
            .then(res => {
                setSousAnswer(res.answer);
            });
    }

    return(
        <Form onSubmit={onSubmit}>
            <Col className="bg-light px-4 pb-2 pt-1">
                <Row>
                    <Col>
                        <Form.Group>
                            <Form.Label className="fw-bold h5">One</Form.Label>
                            <Form.Control type="text" minLength={1} required value={sousOne}
                                          onChange={field => setSousOne(field.target.value)}></Form.Control>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group>
                            <Form.Label className="fw-bold h5">Two</Form.Label>
                            <Form.Control minLength={1} type="text" required value={sousTwo}
                                          onChange={field => setSousTwo(field.target.value)}></Form.Control>
                        </Form.Group>
                    </Col>
                </Row>
                <Row className="mt-3">
                    <Button type="submit" className="btn btn-success mx-auto">Soustraction</Button>
                </Row>
                <Row className="mt-3">
                    <h3>
                        {SousAnswer}
                    </h3>
                </Row>
            </Col>
        </Form>
    );
}

export default Soustraction;