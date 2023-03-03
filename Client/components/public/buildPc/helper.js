import MotherboardIcon from '@/public/images/MotherboardIcon.svg'
import ProcessorIcon from '@/public/images/processorIcon.svg'
import DiskIcon from '@/public/images/diskIcon.svg'
import GPUIcon from '@/public/images/GPUIcon.svg'
import PowerIcon from '@/public/images/PowerIcon.svg'
import RamIcon from '@/public/images/RamIcon.svg'
import ServicesIcon from '@/public/images/servicesIcon.svg'
import TowerIcon from '@/public/images/TowerIcon.svg'
import MonitorIcon from '@/public/images/MonitorIcon.svg'
import OsIcon from '@/public/images/OsIcon.svg'
import UtilsIcon from '@/public/images/UtilsIcon.svg'
import WiFiIcon from '@/public/images/WiFiIcon.svg'
import KeyboardIcon from '@/public/images/KeyboardIcon.svg'
import MouseIcon from '@/public/images/MouseIcon.svg'
import IconoCooler from '@/public/images/IconoCooler.svg'

export const steps = [
  {
    name: 'Microprocesador',
    index: 0,
    Icon: ProcessorIcon,
  },
  {
    name: 'Cooler',
    index: 1,
    Icon: IconoCooler,
  },
  {
    name: 'Motherboard',
    index: 9,
    Icon: MotherboardIcon,
  },
  {
    name: 'Actualizacion de Bios',
    index: 2,
    Icon: ServicesIcon,
  },
  {
    name: 'Memoria RAM',
    index: 3,
    Icon: RamIcon,
  },
  {
    name: 'Placa de Video',
    index: 4,
    Icon: GPUIcon,
  },
  {
    name: 'Disco 1',
    index: 5,
    Icon: DiskIcon,
  },
  {
    name: 'Disco 2',
    index: 6,
    Icon: DiskIcon,
  },
  {
    name: 'Gabinete',
    index: 7,
    Icon: TowerIcon,
  },
  {
    name: 'Fuente',
    index: 8,
    Icon: PowerIcon,
  },
]
export const FullSteps = [
  {
    name: 'Microprocesador',
    index: 1,
    Icon: ProcessorIcon,
    slug: 'Microprocesadores',
  },
  {
    name: 'Cooler',
    index: 2,
    Icon: IconoCooler,
    slug: 'cooler',
  },
  {
    name: 'Motherboard',
    index: 3,
    Icon: MotherboardIcon,
    slug: 'Motherboard',
  },
  // {
  //   name: 'Actualizacion de Bios',
  //   index: 4,
  //   Icon: ServicesIcon,
  //   slug: '',
  // },
  {
    name: 'Memoria RAM',
    index: 4,
    Icon: RamIcon,
    slug: 'Memoria Ram',
  },
  {
    name: 'Placa de Video',
    index: 5,
    Icon: GPUIcon,
    slug: 'Tarjeta de video',
  },
  {
    name: 'Disco 1',
    index: 6,
    Icon: DiskIcon,
    slug: 'disco',
  },
  {
    name: 'Disco 2',
    index: 7,
    Icon: DiskIcon,
    slug: 'disco',
  },
  {
    name: 'Gabinete',
    index: 8,
    Icon: TowerIcon,
    slug: 'Gabinete',
  },
  {
    name: 'Fuente',
    index: 9,
    Icon: PowerIcon,
    slug: 'Fuente',
  },
  {
    name: 'Monitor',
    index: 10,
    Icon: MonitorIcon,
    slug: 'Monitor',
  },
  {
    name: 'Periferico 1',
    index: 11,
    Icon: KeyboardIcon,
    slug: 'Mouse',
  },
  {
    name: 'Periferico 2',
    index: 12,
    Icon: MouseIcon,
    slug: 'Teclado',
  },
  // {
  //   name: 'Placa de Wi-Fi',
  //   index: 14,
  //   Icon: WiFiIcon,
  //   slug: '',
  // },
  // {
  //   name: 'Armado de PC',
  //   index: 15,
  //   Icon: UtilsIcon,
  //   slug: '',
  // },
  // {
  //   name: 'Sistema Operitvo',
  //   index: 16,
  //   Icon: OsIcon,
  //   slug: '',
  // },
]
