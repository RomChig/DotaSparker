import {Button, Col, Form, Row} from "react-bootstrap";

export const MatchesFilter = (
    {
        setMatchNumbers = f => f,
        onSubmit = f => f
    }
) => {
    const handleChange = numbers => setMatchNumbers(numbers);
    return (
        <Row className="align-items-center">
            <Col xs={"auto"}>
                <Form.Group as={Row} className="mb-4 mt-4" controlId="formPlaintextPassword">
                    <Col sm="10">
                        <Form.Control onChange={e => handleChange(e.target.value)}
                                      type="number"
                                      placeholder="match numbers to get"/>
                    </Col>
                </Form.Group>
            </Col>
            <Col xs={"auto"}>
                <Button onClick={onSubmit} variant="btn btn-primary" type="submit">Submit</Button>
            </Col>
        </Row>
    )
}