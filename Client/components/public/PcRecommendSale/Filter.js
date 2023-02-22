import styled from 'styled-components'
import CheckboxSpring from '../../common/Checkbox'

export const Filter = ({ typeOfFilter }) => {
  return (
    <FilterContainer>
      <p>{typeOfFilter}</p>
      <div className="filter">
        <CheckboxSpring text="AMD" quantity="10" />
        <CheckboxSpring text="Intel" quantity="7" />
      </div>
    </FilterContainer>
  )
}

const FilterContainer = styled.div`
  margin: 20px 0;
`
