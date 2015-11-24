
package maqv.msp.types.instrucao;



public final class Decl extends maqv.msp.types.Instrucao implements tom.library.sl.Visitable  {
  
  private static String symbolName = "Decl";


  private Decl() {}
  private int hashCode;
  private static Decl gomProto = new Decl();
    private String _id;
  private int _initMemAddress;
  private int _size;

  /**
   * Constructor that builds a term rooted by Decl
   *
   * @return a term rooted by Decl
   */

  public static Decl make(String _id, int _initMemAddress, int _size) {

    // use the proto as a model
    gomProto.initHashCode( _id,  _initMemAddress,  _size);
    return (Decl) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _id
   * @param _initMemAddress
   * @param _size
   * @param hashCode hashCode of Decl
   */
  private void init(String _id, int _initMemAddress, int _size, int hashCode) {
    this._id = _id.intern();
    this._initMemAddress = _initMemAddress;
    this._size = _size;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _id
   * @param _initMemAddress
   * @param _size
   */
  private void initHashCode(String _id, int _initMemAddress, int _size) {
    this._id = _id.intern();
    this._initMemAddress = _initMemAddress;
    this._size = _size;

    this.hashCode = hashFunction();
  }

  /* name and arity */

  /**
   * Returns the name of the symbol
   *
   * @return the name of the symbol
   */
  @Override
  public String symbolName() {
    return "Decl";
  }

  /**
   * Returns the arity of the symbol
   *
   * @return the arity of the symbol
   */
  private int getArity() {
    return 3;
  }

  /**
   * Copy the object and returns the copy
   *
   * @return a clone of the SharedObject
   */
  public shared.SharedObject duplicate() {
    Decl clone = new Decl();
    clone.init( _id,  _initMemAddress,  _size, hashCode);
    return clone;
  }
  
  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("Decl(");
    buffer.append('"');
            for (int i = 0; i < _id.length(); i++) {
              char c = _id.charAt(i);
              switch (c) {
                case '\n':
                  buffer.append('\\');
                  buffer.append('n');
                  break;
                case '\t':
                  buffer.append('\\');
                  buffer.append('t');
                  break;
                case '\b':
                  buffer.append('\\');
                  buffer.append('b');
                  break;
                case '\r':
                  buffer.append('\\');
                  buffer.append('r');
                  break;
                case '\f':
                  buffer.append('\\');
                  buffer.append('f');
                  break;
                case '\\':
                  buffer.append('\\');
                  buffer.append('\\');
                  break;
                case '\'':
                  buffer.append('\\');
                  buffer.append('\'');
                  break;
                case '\"':
                  buffer.append('\\');
                  buffer.append('\"');
                  break;
                case '!':
                case '@':
                case '#':
                case '$':
                case '%':
                case '^':
                case '&':
                case '*':
                case '(':
                case ')':
                case '-':
                case '_':
                case '+':
                case '=':
                case '|':
                case '~':
                case '{':
                case '}':
                case '[':
                case ']':
                case ';':
                case ':':
                case '<':
                case '>':
                case ',':
                case '.':
                case '?':
                case ' ':
                case '/':
                  buffer.append(c);
                  break;

                default:
                  if (java.lang.Character.isLetterOrDigit(c)) {
                    buffer.append(c);
                  } else {
                    buffer.append('\\');
                    buffer.append((char) ('0' + c / 64));
                    c = (char) (c % 64);
                    buffer.append((char) ('0' + c / 8));
                    c = (char) (c % 8);
                    buffer.append((char) ('0' + c));
                  }
              }
            }
            buffer.append('"');
buffer.append(",");
    buffer.append(_initMemAddress);
buffer.append(",");
    buffer.append(_size);

    buffer.append(")");
  }


  /**
   * Compares two terms. This functions implements a total lexicographic path ordering.
   *
   * @param o object to which this term is compared
   * @return a negative integer, zero, or a positive integer as this
   *         term is less than, equal to, or greater than the argument
   * @throws ClassCastException in case of invalid arguments
   * @throws RuntimeException if unable to compare children
   */
  @Override
  public int compareToLPO(Object o) {
    /*
     * We do not want to compare with any object, only members of the module
     * In case of invalid argument, throw a ClassCastException, as the java api
     * asks for it
     */
    maqv.msp.mspAbstractType ao = (maqv.msp.mspAbstractType) o;
    /* return 0 for equality */
    if (ao == this) { return 0; }
    /* compare the symbols */
    int symbCmp = this.symbolName().compareTo(ao.symbolName());
    if (symbCmp != 0) { return symbCmp; }
    /* compare the children */
    Decl tco = (Decl) ao;
    int _idCmp = (this._id).compareTo(tco._id);
    if(_idCmp != 0) {
      return _idCmp;
    }


    if( this._initMemAddress != tco._initMemAddress) {
      return (this._initMemAddress < tco._initMemAddress)?-1:1;
    }

    if( this._size != tco._size) {
      return (this._size < tco._size)?-1:1;
    }

    throw new RuntimeException("Unable to compare");
  }

 /**
   * Compares two terms. This functions implements a total order.
   *
   * @param o object to which this term is compared
   * @return a negative integer, zero, or a positive integer as this
   *         term is less than, equal to, or greater than the argument
   * @throws ClassCastException in case of invalid arguments
   * @throws RuntimeException if unable to compare children
   */
  @Override
  public int compareTo(Object o) {
    /*
     * We do not want to compare with any object, only members of the module
     * In case of invalid argument, throw a ClassCastException, as the java api
     * asks for it
     */
    maqv.msp.mspAbstractType ao = (maqv.msp.mspAbstractType) o;
    /* return 0 for equality */
    if (ao == this) { return 0; }
    /* use the hash values to discriminate */

    if(hashCode != ao.hashCode()) { return (hashCode < ao.hashCode())?-1:1; }

    /* If not, compare the symbols : back to the normal order */
    int symbCmp = this.symbolName().compareTo(ao.symbolName());
    if (symbCmp != 0) { return symbCmp; }
    /* last resort: compare the children */
    Decl tco = (Decl) ao;
    int _idCmp = (this._id).compareTo(tco._id);
    if(_idCmp != 0) {
      return _idCmp;
    }


    if( this._initMemAddress != tco._initMemAddress) {
      return (this._initMemAddress < tco._initMemAddress)?-1:1;
    }

    if( this._size != tco._size) {
      return (this._size < tco._size)?-1:1;
    }

    throw new RuntimeException("Unable to compare");
  }

 //shared.SharedObject
  /**
   * Returns hashCode
   *
   * @return hashCode
   */
  @Override
  public final int hashCode() {
    return hashCode;
  }

  /**
   * Checks if a SharedObject is equivalent to the current object
   *
   * @param obj SharedObject to test
   * @return true if obj is a Decl and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof Decl) {

      Decl peer = (Decl) obj;
      return _id==peer._id && _initMemAddress==peer._initMemAddress && _size==peer._size && true;
    }
    return false;
  }


   //Instrucao interface
  /**
   * Returns true if the term is rooted by the symbol Decl
   *
   * @return true, because this is rooted by Decl
   */
  @Override
  public boolean isDecl() {
    return true;
  }
  
  /**
   * Returns the attribute String
   *
   * @return the attribute String
   */
  @Override
  public String getid() {
    return _id;
  }

  /**
   * Sets and returns the attribute maqv.msp.types.Instrucao
   *
   * @param set_arg the argument to set
   * @return the attribute String which just has been set
   */
  @Override
  public maqv.msp.types.Instrucao setid(String set_arg) {
    return make(set_arg, _initMemAddress, _size);
  }
  
  /**
   * Returns the attribute int
   *
   * @return the attribute int
   */
  @Override
  public int getinitMemAddress() {
    return _initMemAddress;
  }

  /**
   * Sets and returns the attribute maqv.msp.types.Instrucao
   *
   * @param set_arg the argument to set
   * @return the attribute int which just has been set
   */
  @Override
  public maqv.msp.types.Instrucao setinitMemAddress(int set_arg) {
    return make(_id, set_arg, _size);
  }
  
  /**
   * Returns the attribute int
   *
   * @return the attribute int
   */
  @Override
  public int getsize() {
    return _size;
  }

  /**
   * Sets and returns the attribute maqv.msp.types.Instrucao
   *
   * @param set_arg the argument to set
   * @return the attribute int which just has been set
   */
  @Override
  public maqv.msp.types.Instrucao setsize(int set_arg) {
    return make(_id, _initMemAddress, set_arg);
  }
  
  /* AbstractType */
  /**
   * Returns an ATerm representation of this term.
   *
   * @return an ATerm representation of this term.
   */
  @Override
  public aterm.ATerm toATerm() {
    aterm.ATerm res = super.toATerm();
    if(res != null) {
      // the super class has produced an ATerm (may be a variadic operator)
      return res;
    }
    return atermFactory.makeAppl(
      atermFactory.makeAFun(symbolName(),getArity(),false),
      new aterm.ATerm[] {(aterm.ATerm) atermFactory.makeAppl(atermFactory.makeAFun(getid() ,0 , true)), (aterm.ATerm) atermFactory.makeInt(getinitMemAddress()), (aterm.ATerm) atermFactory.makeInt(getsize())});
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a maqv.msp.types.Instrucao from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.Instrucao fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if(symbolName.equals(appl.getName()) && !appl.getAFun().isQuoted()) {
        return make(
convertATermToString(appl.getArgument(0), atConv), convertATermToInt(appl.getArgument(1), atConv), convertATermToInt(appl.getArgument(2), atConv)
        );
      }
    }
    return null;
  }

  /* Visitable */
  /**
   * Returns the number of children of the term
   *
   * @return the number of children of the term
   */
  public int getChildCount() {
    return 3;
  }

  /**
   * Returns the child at the specified index
   *
   * @param index index of the child to return; must be
             nonnegative and less than the childCount
   * @return the child at the specified index
   * @throws IndexOutOfBoundsException if the index out of range
   */
  public tom.library.sl.Visitable getChildAt(int index) {
        switch(index) {
      case 0: return new tom.library.sl.VisitableBuiltin<String>(_id);
      case 1: return new tom.library.sl.VisitableBuiltin<java.lang.Integer>(_initMemAddress);
      case 2: return new tom.library.sl.VisitableBuiltin<java.lang.Integer>(_size);
      default: throw new IndexOutOfBoundsException();
 }
 }

  /**
   * Set the child at the specified index
   *
   * @param index index of the child to set; must be
             nonnegative and less than the childCount
   * @param v child to set at the specified index
   * @return the child which was just set
   * @throws IndexOutOfBoundsException if the index out of range
   */
  public tom.library.sl.Visitable setChildAt(int index, tom.library.sl.Visitable v) {
        switch(index) {
      case 0: return make(getid(), getinitMemAddress(), getsize());
      case 1: return make(getid(), getinitMemAddress(), getsize());
      case 2: return make(getid(), getinitMemAddress(), getsize());
      default: throw new IndexOutOfBoundsException();
 }
  }

  /**
   * Set children to the term
   *
   * @param children array of children to set
   * @return an array of children which just were set
   * @throws IndexOutOfBoundsException if length of "children" is different than 3
   */
  @SuppressWarnings("unchecked")
  public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
    if (children.length == getChildCount()  && children[0] instanceof tom.library.sl.VisitableBuiltin && children[1] instanceof tom.library.sl.VisitableBuiltin && children[2] instanceof tom.library.sl.VisitableBuiltin) {
      return make(((tom.library.sl.VisitableBuiltin<String>)children[0]).getBuiltin(), ((tom.library.sl.VisitableBuiltin<java.lang.Integer>)children[1]).getBuiltin(), ((tom.library.sl.VisitableBuiltin<java.lang.Integer>)children[2]).getBuiltin());
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * Returns the whole children of the term
   *
   * @return the children of the term
   */
  public tom.library.sl.Visitable[] getChildren() {
    return new tom.library.sl.Visitable[] { new tom.library.sl.VisitableBuiltin<String>(_id),  new tom.library.sl.VisitableBuiltin<java.lang.Integer>(_initMemAddress),  new tom.library.sl.VisitableBuiltin<java.lang.Integer>(_size)};
  }

    /**
     * Compute a hashcode for this term.
     * (for internal use)
     *
     * @return a hash value
     */
  protected int hashFunction() {
    int a, b, c;
    /* Set up the internal state */
    a = 0x9e3779b9; /* the golden ratio; an arbitrary value */
    b = (238699661<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (shared.HashFunctions.stringHashFunction(_id, 2) << 16);
    a += (_initMemAddress << 8);
    a += (_size);

    a -= b; a -= c; a ^= (c >> 13);
    b -= c; b -= a; b ^= (a << 8);
    c -= a; c -= b; c ^= (b >> 13);
    a -= b; a -= c; a ^= (c >> 12);
    b -= c; b -= a; b ^= (a << 16);
    c -= a; c -= b; c ^= (b >> 5);
    a -= b; a -= c; a ^= (c >> 3);
    b -= c; b -= a; b ^= (a << 10);
    c -= a; c -= b; c ^= (b >> 15);
    /* ------------------------------------------- report the result */
    return c;
  }

  /**
    * function that returns functional version of the current operator
    * need for initializing the Enumerator
    */
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<String>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao>>>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<String>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao>>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao>>> apply(final tom.library.enumerator.Enumeration<String> t1) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao>> apply(final tom.library.enumerator.Enumeration<java.lang.Integer> t2) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao>>() {
          public tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao> apply(final tom.library.enumerator.Enumeration<java.lang.Integer> t3) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<String,tom.library.enumerator.F<java.lang.Integer,tom.library.enumerator.F<java.lang.Integer,maqv.msp.types.Instrucao>>>) 
        new tom.library.enumerator.F<String,tom.library.enumerator.F<java.lang.Integer,tom.library.enumerator.F<java.lang.Integer,maqv.msp.types.Instrucao>>>() {
          public tom.library.enumerator.F<java.lang.Integer,tom.library.enumerator.F<java.lang.Integer,maqv.msp.types.Instrucao>> apply(final String t1) {
            return 
        new tom.library.enumerator.F<java.lang.Integer,tom.library.enumerator.F<java.lang.Integer,maqv.msp.types.Instrucao>>() {
          public tom.library.enumerator.F<java.lang.Integer,maqv.msp.types.Instrucao> apply(final java.lang.Integer t2) {
            return 
        new tom.library.enumerator.F<java.lang.Integer,maqv.msp.types.Instrucao>() {
          public maqv.msp.types.Instrucao apply(final java.lang.Integer t3) {
            return make(t1,java.lang.Integer.valueOf(t2),java.lang.Integer.valueOf(t3));
          }
        };
          }
        };
          }
        }),t1),t2),t3).pay();
          }
        };
          }
        };
          }
        };
  }

}