import {Pagination, PageItem} from "react-bootstrap";
import {useState} from "react";

export const EntityPagination = (
    {
        entityPerPage,
        totalEntities,
        paginate = f => f
    }
) => {
    const pageNumbers = [];
    const [activeButtonNumber, setActiveButtonNumber] = useState(1);
    const handleClick = number => {
        setActiveButtonNumber(number);
        paginate(number);
    }
    const populatePageNumbers = () => {
        for (let number = 1; number <= Math.ceil(totalEntities / entityPerPage); number++) {
            pageNumbers.push(
                <PageItem onClick={() => handleClick(number)}
                          key={number}
                          active={number === activeButtonNumber}>
                    {number}
                </PageItem>
            );
        }
    }
    populatePageNumbers();
    return (
        totalEntities > entityPerPage ? <Pagination>{pageNumbers}</Pagination> : ''
    )
}