import {Button, Form, FormControl, Nav, Navbar, NavDropdown} from "react-bootstrap";
import {NavLink, useHistory} from "react-router-dom";
import {PATH_TO_MAIN_PAGE} from "../util";

const Header = () => {
    const history = useHistory();
    return <Navbar bg="dark" expand="lg" variant="dark">
        <Navbar.Brand onClick={() => history.push(PATH_TO_MAIN_PAGE)}>DotaSparker</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll"/>
        <Navbar.Collapse id="navbarScroll">
            <Nav
                className="mr-auto my-2 my-lg-0"
                style={{maxHeight: '100px'}}
                navbarScroll
            >
                <Nav.Link href="#action2">Account</Nav.Link>
                <NavDropdown title="Account" id="navbarScrollingDropdown">
                    <NavDropdown.Item href="/matches">
                        <NavLink to={'/matches'}>My matches</NavLink>
                    </NavDropdown.Item>
                    <NavDropdown.Item href="#action4">Log in</NavDropdown.Item>
                    <NavDropdown.Divider/>
                    <NavDropdown.Item href="#action5">Sign in</NavDropdown.Item>
                </NavDropdown>
            </Nav>
            <Form className="d-flex">
                <FormControl
                    type="search"
                    placeholder="Search"
                    className="mr-2"
                    aria-label="Search"
                />
                <Button variant="outline-primary">Search</Button>
            </Form>
        </Navbar.Collapse>
    </Navbar>
}

export default Header;