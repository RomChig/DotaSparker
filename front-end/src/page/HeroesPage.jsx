import {Table} from "react-bootstrap";
import {Hero} from "../model";
import {useState} from "react";
import {EntityPagination} from "../component";
import {calculateCurrentEntitiesViaPagePagination} from "../util";

export const HeroesPage = ({heroes}) => {
    const [currentPage, setCurrentPage] = useState(1);
    const [heroPerPage] = useState(7);
    const currentHeroes = calculateCurrentEntitiesViaPagePagination(heroes, currentPage);

    const paginate = pageNumber => setCurrentPage(pageNumber);
    return (
        <div>
            <Table striped bordered hover variant="dark" className='text-center'>
                <thead>
                <tr>
                    <th>id</th>
                    <th>picture</th>
                    <th>Localized Name</th>
                    <th>Name</th>
                </tr>
                </thead>
                {
                    currentHeroes.map((hero, index) => <Hero key={index} hero={hero}/>)
                }
            </Table>
            <EntityPagination totalEntities={heroes.length}
                              entityPerPage={heroPerPage}
                              paginate={paginate}/>
        </div>
    )
}