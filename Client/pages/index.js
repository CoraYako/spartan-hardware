import Head from 'next/head'
import { motion } from 'framer-motion'
import { Outstanding } from '@/components/public/home/Outstanding'
import { PromotionCard } from '@/components/common/PromotionCard'
import { Promotions } from '@/components/public/home/Promotions'
import {Recommend} from '@/components/public/home/Recommned'

export default function Home() {
  return (
    <>
      <Head>
        <title>Spartan Hardware</title>
        <meta name="description" content="Generated by create next app" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <motion.div
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        exit={{ opacity: 0 }}
        key="home"
        style={{ width: '100%' }}
      >
	<Recommend />
        <Outstanding />
        <Promotions />
      </motion.div>
    </>
  )
}
