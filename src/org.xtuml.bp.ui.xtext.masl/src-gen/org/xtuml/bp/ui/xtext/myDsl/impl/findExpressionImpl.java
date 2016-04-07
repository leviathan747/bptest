/**
 * generated by Xtext 2.9.1
 */
package org.xtuml.bp.ui.xtext.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtuml.bp.ui.xtext.myDsl.MyDslPackage;
import org.xtuml.bp.ui.xtext.myDsl.findExpression;
import org.xtuml.bp.ui.xtext.myDsl.postfixNoCallExpression;
import org.xtuml.bp.ui.xtext.myDsl.whereClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>find Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtuml.bp.ui.xtext.myDsl.impl.findExpressionImpl#getP <em>P</em>}</li>
 *   <li>{@link org.xtuml.bp.ui.xtext.myDsl.impl.findExpressionImpl#getW <em>W</em>}</li>
 * </ul>
 *
 * @generated
 */
public class findExpressionImpl extends extendedExpressionImpl implements findExpression
{
  /**
   * The cached value of the '{@link #getP() <em>P</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getP()
   * @generated
   * @ordered
   */
  protected postfixNoCallExpression p;

  /**
   * The cached value of the '{@link #getW() <em>W</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getW()
   * @generated
   * @ordered
   */
  protected whereClause w;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected findExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyDslPackage.Literals.FIND_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public postfixNoCallExpression getP()
  {
    return p;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetP(postfixNoCallExpression newP, NotificationChain msgs)
  {
    postfixNoCallExpression oldP = p;
    p = newP;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.FIND_EXPRESSION__P, oldP, newP);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setP(postfixNoCallExpression newP)
  {
    if (newP != p)
    {
      NotificationChain msgs = null;
      if (p != null)
        msgs = ((InternalEObject)p).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.FIND_EXPRESSION__P, null, msgs);
      if (newP != null)
        msgs = ((InternalEObject)newP).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.FIND_EXPRESSION__P, null, msgs);
      msgs = basicSetP(newP, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.FIND_EXPRESSION__P, newP, newP));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public whereClause getW()
  {
    return w;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetW(whereClause newW, NotificationChain msgs)
  {
    whereClause oldW = w;
    w = newW;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.FIND_EXPRESSION__W, oldW, newW);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setW(whereClause newW)
  {
    if (newW != w)
    {
      NotificationChain msgs = null;
      if (w != null)
        msgs = ((InternalEObject)w).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.FIND_EXPRESSION__W, null, msgs);
      if (newW != null)
        msgs = ((InternalEObject)newW).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.FIND_EXPRESSION__W, null, msgs);
      msgs = basicSetW(newW, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.FIND_EXPRESSION__W, newW, newW));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyDslPackage.FIND_EXPRESSION__P:
        return basicSetP(null, msgs);
      case MyDslPackage.FIND_EXPRESSION__W:
        return basicSetW(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyDslPackage.FIND_EXPRESSION__P:
        return getP();
      case MyDslPackage.FIND_EXPRESSION__W:
        return getW();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.FIND_EXPRESSION__P:
        setP((postfixNoCallExpression)newValue);
        return;
      case MyDslPackage.FIND_EXPRESSION__W:
        setW((whereClause)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.FIND_EXPRESSION__P:
        setP((postfixNoCallExpression)null);
        return;
      case MyDslPackage.FIND_EXPRESSION__W:
        setW((whereClause)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.FIND_EXPRESSION__P:
        return p != null;
      case MyDslPackage.FIND_EXPRESSION__W:
        return w != null;
    }
    return super.eIsSet(featureID);
  }

} //findExpressionImpl
