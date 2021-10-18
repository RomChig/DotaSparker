export const calculateCurrentEntitiesViaPagePagination = (
    entities,
    currentPage,
    initialEntityNumbers = 7
) => {
    const indexOfLastEntity = currentPage * initialEntityNumbers;
    const indexOfFirstEntity = indexOfLastEntity - initialEntityNumbers;
    return entities.slice(indexOfFirstEntity, indexOfLastEntity);
}
