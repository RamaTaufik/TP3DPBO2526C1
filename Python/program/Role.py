from Equipment import Equipment

class Role:
  def __init__(self, i="", n="", h=0, s=0, d=0, m=0):
    self.__id = ""
    self.__name = ""
    self.__health = 0
    self.__base_str = 0
    self.__base_def = 0
    self.__base_mgc = 0
    self.equipments = []

    if i or n or h or s or d or m:
      self.setId(i)
      self.setName(n)
      self.setHealth(h)
      self.setBaseStr(s)
      self.setBaseDef(d)
      self.setBaseMgc(m)

  def setId(self, i):
    if not i or not i.strip():
      print("ID tidak boleh kosong!")
      return -1

    self.__id = i
    return 0

  def getId(self):
    return self.__id

  def setName(self, n):
    if not n or not n.strip():
      print("Nama tidak boleh kosong!")
      return -1

    self.__name = n
    return 0

  def getName(self):
    return self.__name

  def setHealth(self, h):
    if h < 0:
      print("Health harus bilangan bulat positif!")
      return -1

    self.__health = h
    return 0

  def getHealth(self):
    return self.__health

  def setBaseStr(self, s):
    if s < 0:
      print("Stat STR harus bilangan bulat positif!")
      return -1

    self.__base_str = s
    return 0

  def getBaseStr(self):
    return self.__base_str

  def setBaseDef(self, d):
    if d < 0:
      print("Stat DEF harus bilangan bulat positif!")
      return -1

    self.__base_def = d
    return 0

  def getBaseDef(self):
    return self.__base_def

  def setBaseMgc(self, m):
    if m < 0:
      print("State MGC harus bilangan bulat positif!")
      return -1

    self.__base_mgc = m
    return 0

  def getBaseMgc(self):
    return self.__base_mgc

  def getFinStr(self):
    str_val = self.__base_str

    for e in self.equipments:
      str_val += e.getStr()

    return str_val

  def getFinDef(self):
    def_val = self.__base_def

    for e in self.equipments:
      def_val += e.getDef()

    return def_val

  def getFinMgc(self):
    mgc_val = self.__base_mgc

    for e in self.equipments:
      mgc_val += e.getMgc()

    return mgc_val

  def addEquipment(self, e):
    self.equipments.append(e)

  def getEquipments(self):
    return self.equipments