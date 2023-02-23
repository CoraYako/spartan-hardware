import { useState } from 'react'
import {
  animated,
  useSpring,
  config,
  useSpringRef,
  useChain,
} from 'react-spring'
import styled from 'styled-components'

const CheckboxContainer = styled.label`
  display: flex;
  cursor: pointer;
  user-select: none;
  align-items: center;
  &.checkbox {
    display: inline-block;
    height: 20px;
    width: 20px;
    background: #fff;
    border: 2px #ddd solid;
    margin-right: 4px;
  }

  p {
    font-weight: 500 !important;
    font-size: 14px !important;
    line-height: 26px;
    @media (max-width: 768px) {
      margin: 0;
      max-width: 250px;
      text-align: ${(props) => props.textAling};
    }
  }
`

const HiddenCheckbox = styled.input.attrs({ type: 'checkbox' })`
  clip: rect(0 0 0 0);
  clip-path: inset(50%);
  height: 1px;
  overflow: hidden;
  position: absolute;
  white-space: nowrap;
  width: 1px;
`

function CheckboxSpring({ onChange, disabled, text = '', quantity }) {
  const [isChecked, setIsChecked] = useState(false)
  const checkboxAnimationRef = useSpringRef()
  const checkboxAnimationStyle = useSpring({
    backgroundColor: isChecked ? '#3E2D5C' : '#FFF',
    config: config.gentle,
    ref: checkboxAnimationRef,
    width: '17px',
    height: '17px',
    borderRadius: '3px',
    border: isChecked ? '2px solid #3E2D5C' : '2px solid #8497A6',
    padding: '1px',
    margin: '0 1rem 0 0',
  })

  const [checkmarkLength, setCheckmarkLength] = useState(null)

  const checkmarkAnimationRef = useSpringRef()
  const checkmarkAnimationStyle = useSpring({
    x: isChecked ? 0 : checkmarkLength,
    config: config.gentle,
    ref: checkmarkAnimationRef,
  })

  useChain(
    isChecked
      ? [checkboxAnimationRef, checkmarkAnimationRef]
      : [checkmarkAnimationRef, checkboxAnimationRef],
    [0, 0.1],
  )

  return (
    <CheckboxContainer>
      <HiddenCheckbox
        type="checkbox"
        onChange={() => setIsChecked(!isChecked)}
      />
      <animated.svg
        style={checkboxAnimationStyle}
        className={`checkbox ${isChecked ? 'checkbox--active' : ''}`}
        // This element is purely decorative so
        // we hide it for screen readers
        aria-hidden="true"
        viewBox="0 0 15 11"
        fill="none"
      >
        <animated.path
          d="M1 4.5L5 9L14 1"
          strokeWidth="2"
          stroke="#fff"
          ref={(ref) => {
            if (ref) {
              setCheckmarkLength(ref.getTotalLength())
            }
          }}
          strokeDasharray={checkmarkLength}
          strokeDashoffset={checkmarkAnimationStyle.x}
        />
      </animated.svg>
      <p>
        {text} ({quantity})
      </p>
    </CheckboxContainer>
  )
}

export default CheckboxSpring
