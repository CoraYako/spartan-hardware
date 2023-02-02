import { motion } from 'framer-motion'

const SearchIcon = (props) => (
  <motion.svg
    xmlns="http://www.w3.org/2000/svg"
    width={38}
    height={38}
    viewBox="0 0 24 24"
    {...props}
    initial={{ opacity: 0 }}
    animate={{ opacity: 1 }}
    transition={{ duration: 0.5, delay: 1 }}
  >
    <path
      fill="currentColor"
      d="M9.5 4a6.5 6.5 0 0 1 6.5 6.5c0 1.62-.59 3.1-1.57 4.23l5.65 5.65-.71.71-5.65-5.65A6.469 6.469 0 0 1 9.5 17 6.5 6.5 0 0 1 3 10.5 6.5 6.5 0 0 1 9.5 4m0 1A5.5 5.5 0 0 0 4 10.5 5.5 5.5 0 0 0 9.5 16a5.5 5.5 0 0 0 5.5-5.5A5.5 5.5 0 0 0 9.5 5Z"
    />
  </motion.svg>
)

export default SearchIcon
